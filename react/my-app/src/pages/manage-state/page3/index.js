import { useState } from "react";
import ContactList from "./ContactList";
import Chat from "./Chat";

export default function Message() {
    const [to, setTo] =  useState(contacts[0])
    return (
        <div>
            <ContactList
                contacts={contacts}
                selectedContact={to}
                onSelect={contact => setTo(contact)}
            />
            <Chat key={to.email} contact={to}/>

        </div>
    )
}

const contacts = [
    { name: 'Taylor', email: 'taylor@mail.com' },
    { name: 'Alice', email: 'alice@mail.com' },
    { name: 'Bob', email: 'bob@mail.com' }
];