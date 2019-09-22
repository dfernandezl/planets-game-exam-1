export default {
  newUniverse: {
    request: {
      method: "PUT",
      url: "/api/v1/game",
      body: { mapCode: "TwoStars" },
    },
    response: {},
  },
  yours0: {
    request: {
      method: "GET",
      url: "/api/v1/players/yours",
      body: null,
    },
    response: {
      status: 200,
      body: {
        playerId: "yours",
        map: {
          rows: 8,
          columns: 8,
        },
        entities: [
          {
            id: "Bajor",
            type: "star",
            row: 3,
            column: 3,
            size: 9,
            playerId: "yours",
            population: 100,
          },
          {
            id: "Cardassia",
            type: "star",
            row: 3,
            column: 4,
            size: 9,
          },
        ],
      },
    },
  },
  save0: {
    request: {
      method: "PUT",
      url: "/api/v1/players/yours/commands",
      body: [{ entityId: "Bajor", type: "BuildShip", value: "Defiant" }],
    },
    response: {},
  },
  "yours0.1": {
    request: {
      method: "GET",
      url: "/api/v1/players/yours",
      body: null,
    },
    response: {
      status: 200,
      body: {
        playerId: "yours",
        map: {
          rows: 8,
          columns: 8,
        },
        entities: [
          {
            id: "Bajor",
            type: "star",
            row: 3,
            column: 3,
            size: 9,
            playerId: "yours",
            population: 100,
          },
          {
            id: "Cardassia",
            type: "star",
            row: 3,
            column: 4,
            size: 9,
          },
        ],
        commands: [{ entityId: "Bajor", type: "BuildShip", value: "Defiant" }],
      },
    },
  },
  compile1: {
    request: {
      method: "POST",
      url: "/api/v1/players/yours",
      body: null,
    },
    response: {
      status: 200,
      body: {
        playerId: "yours",
        map: {
          rows: 8,
          columns: 8,
        },
        entities: [
          {
            id: "Bajor",
            type: "star",
            row: 3,
            column: 3,
            size: 9,
            playerId: "yours",
            population: 100,
          },
          {
            id: "Defiant",
            type: "ship",
            row: 3,
            column: 3,
            playerId: "yours",
            population: 0,
          },
          {
            id: "Cardassia",
            type: "star",
            row: 3,
            column: 4,
            size: 9,
          },
        ],
      },
    },
  },
};
