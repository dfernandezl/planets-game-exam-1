const api = {
  async get(url, options) {
    const response = await fetch(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        ...(options && options.headers),
      },
      ...options,
    });

    const result = await response.json();

    if (!response.ok)
      return Promise.reject({
        status: response.status,
        data: result,
      });

    return result;
  },

  async put(url, body, options) {
    return api.get(url, {
      method: "PUT",
      body: JSON.stringify(body),
      ...options,
    });
  },

  async post(url, body, options) {
    return api.get(url, {
      method: "POST",
      body: JSON.stringify(body),
      ...options,
    });
  },

  async delete(url, options) {
    return api.get(url, { method: "DELETE", ...options });
  },
};

export default api;
