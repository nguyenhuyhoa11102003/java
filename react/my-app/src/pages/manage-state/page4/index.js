import AddTask from "./AddTask";
import TaskList from "./TaskList";
import { act, useReducer } from 'react';

export default function App() {
    const [tasks, dispatch] = useReducer(
        tasksReducer,
        initialTasks
    );
    function addTask(text) {
        dispatch({
            type: 'added',
            id: nextId++,
            text: text
        });
    }
    function tasksReducer(tasks, action) {
        switch (action.type) {
            case 'changed': {
                return tasks.map(t => {
                    if (t.id === action.task.id) {
                        return action.task;
                    } else {
                        return t;
                    }
                });
            }
            case 'added':
                return [...tasks, {
                    id: action.id,
                    text: action.text,
                    done: false
                }];

            case 'deleted':
                return tasks.filter(t => t.id !== action.id);
            default: {
                throw Error('Unknown action: ' + action.type);
            }
        }
    }

    function onChangeTask(task) {
        dispatch({
            type: 'changed',
            task: task
        });
    }

    function onDeleteTask(id) {
        dispatch({
            type: 'deleted',
            id: id
        })
    }

    return (
        <>
            <AddTask onAddTask={addTask} />
            <TaskList
                tasks={tasks}
                onChangeTask={onChangeTask}
                onDeleteTask={onDeleteTask}
            />
        </>
    )
}

let nextId = 3;
const initialTasks = [
    { id: 0, text: 'Visit Kafka Museum', done: true },
    { id: 1, text: 'Watch a puppet show', done: false },
    { id: 2, text: 'Lennon Wall pic', done: false }
];
