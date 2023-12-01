import {AutoCrud} from "@hilla/react-crud";
import {TodoService} from "Frontend/generated/endpoints.js";
import TodoModel from "Frontend/generated/com/example/application/TodoModel";
import Todo from "Frontend/generated/com/example/application/Todo";
import { Icon } from '@hilla/react-components/Icon.js';

export default function TodoView() {
    return (
        <>
            <AutoCrud service={TodoService} model={TodoModel}
                      formProps={{
                          visibleFields: ['task', 'done']
                      }}
                      gridProps={{
                          columnOptions: {
                              done: {
                                  renderer: ({item}: { item: Todo }) => {
                                      return item.done ? <Icon icon="lumo:checkmark" style={{color:'green'}} ></Icon> : <></>;
                                  }
                              }
                          }
                      }}
            ></AutoCrud>
        </>
    );
}
