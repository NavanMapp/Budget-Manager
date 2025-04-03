import { React, createContext, useState } from "react"
import { uploadReceipt } from "../services/expenseService"
import { createBudget } from "../services/budgetService"
import { Form } from "react-router"

function ExpenseForm({budgetId}) {
    const [file, setFile] = useState(null)

    const handleSubmit = async (values) => {
        const expense = await createBudget({
            values,
            budgetId,
            amount: parseFloat(values.amount)
        })

        if (file) {
            await uploadReceipt(expense.id, file)
        }
    }

    return (
        <Form onSubmit={handleSubmit}>
            <input 
                type='file'
                onChange={(e) => setFile(e.target.file[0])}
            />
        </Form>
    )
}
