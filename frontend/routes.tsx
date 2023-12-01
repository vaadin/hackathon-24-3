import TodoView from "Frontend/views/TodoView";
import {
    createBrowserRouter,
    RouteObject
} from "react-router-dom";

export const routes: readonly RouteObject[] = [
  { path: "/", element: <TodoView /> },
];

export const router = createBrowserRouter([...routes], {basename: new URL(document.baseURI).pathname });
