import React, { useState } from 'react'
import ExpenseItems from '../components/ExpenseItems'

function Expenses() {

  const [expenses, setExpenses] = useState([
    { id: 1, description: 'Groceries', category: 'Food', amount: 150, date: '2023-05-15' },
    { id: 2, description: 'Bus fare', category: 'Transport', amount: 30, date: '2023-05-14' },
  ])

  const [newExpense, setNewExpense] = useState({
    description:'',
    category:'Food',
    amount:'',
    date: new Date().toISOString().split('T')[0]
  })

  const categories = ['Food', 'Transport', 'Entertainment', 'Utilities', 'Other']

  const handleAddExpense = (e) => {
    e.preventDefault()
    const expense = {
      id: expense.length + 1,
      ...newExpense,
      amount: parseFloat(newExpense.amount)
    }
    setExpenses([...expenses, expense])
    setNewExpense({
      description:'',
      category:'Food',
      amount:'',
      date: new Date().toISOString().split('T')[0]
    })
  }
  return (
    <div className='expenses-page'>
      <h1>Expense Tracker</h1>

      <div className='expenses-list'>
        {expenses.map(exp => (
          <ExpenseItems key={exp.id} expense={exp} />
        ))}
      </div>

      <div className='expense-form'>
        <form onSubmit={handleAddExpense}>
          <input 
            type='text'
            placeholder='Description'
            value={newExpense.description}
            onChange={(e) => setNewExpense({...newExpense, description: e.target.value})}
            required
          />

          <select
            value={newExpense.category}
            onChange={(e) => setNewExpense({...newExpense, category:e.target.value })}
          ></select>
          <input 
            type='number'
            placeholder='Amount'
            value={newExpense.amount}
            onChange={(e) => setNewExpense({...newExpense, description: e.target.value})}
            required
            min='0'
            step='0.01'
            />
            <input 
              type='date'
              value={newExpense.date}
              onChange={(e) => setNewExpense({...newExpense, date: e.target.value})}
            />
            <button type='submit'>Add Expense</button>
        </form>
      </div>
    </div>
  )
}

export default Expenses
