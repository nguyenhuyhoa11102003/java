import { useState } from "react"
import { useTasksDispatch, initialTasks } from "./TasksContext"

export default function AddTask({ onAddTask }) {
    const [text, setText] = useState('')
    const dispatch = useTasksDispatch();
    return (
        <>
            <input
                placeholder="add task"
                value={text}
                onChange={e => setText(e.target.value)}
            />
            <button onClick={() => {
                setText('')
                // onAddTask(text)
                dispatch({
                    type: 'added',
                    id: initialTasks.length++,
                    text: text,
                })
            }}>
                ADD
            </button>
        </>
    )
}

