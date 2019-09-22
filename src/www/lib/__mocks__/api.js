const interactions = [];
let deferPopInteraction = null;

const apiMock = {
  get(url, { method = "GET", body = null } = {}) {
    return new Promise((resolve, reject) => {
      interactions.push({
        request: { url, method, body },
        resolve(status = 200, data) {
          const ok = 200 <= status && status <= 299;
          if (!ok) return reject({ status, data });

          resolve(data);
        },
      });
    });
  },

  put(url, body) {
    return this.get(url, { method: "PUT", body });
  },

  post(url, body) {
    return this.get(url, { method: "POST", body });
  },

  delete(url, body) {
    return this.get(url, { method: "DELETE", body });
  },

  async popLastInteraction() {
    while (!interactions.length) {
      await new Promise(r => setTimeout(r, 50));
    }
    return interactions.pop();
  },

  getInteractions() {
    return interactions;
  },
};

export default apiMock;
