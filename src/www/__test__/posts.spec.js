import { getByTestId, getByText, findByText } from "@testing-library/dom";
import api from "../lib/api";
import { renderApp } from "./renderApp";
jest.mock("../lib/api");

function clickMainHeaderLink(container, linkText) {
  const header = getByTestId(container, "header");
  const link = getByText(header, linkText);
  link.click();
}

async function mockPostListInteraction() {
  const fetchList = await api.popLastInteraction();
  expect(fetchList.request).toMatchObject({
    url: "/api/v1/posts",
    method: "GET",
  });
  fetchList.resolve(200, {
    list: [
      { id: "p1", title: "Let there be light" },
      { id: "p2", title: "Your own star" },
      { id: "p3", title: "Exterminate" },
    ],
  });
}

async function mockPostInteraction(id, title, body) {
  const fetchItem = await api.popLastInteraction();
  expect(fetchItem.request).toMatchObject({
    url: `/api/v1/posts/${id}`,
    method: "GET",
  });
  fetchItem.resolve(200, { id, title, body });
}

test("there is a list of posts", async () => {
  const { container } = renderApp();

  clickMainHeaderLink(container, "Blog");
  await mockPostListInteraction();

  await findByText(container, "Let there be light");
  await findByText(container, "Exterminate");
});

test("shows the content of one post", async () => {
  const { container } = renderApp();

  clickMainHeaderLink(container, "Blog");
  await mockPostListInteraction();

  const exterminate = await findByText(container, "Exterminate");
  exterminate.click();
  await mockPostInteraction("p3", "Exterminate", "The exterminator guide");

  await findByText(container, "Exterminate");
  await findByText(container, "The exterminator guide");
});
