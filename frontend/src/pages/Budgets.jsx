import React, { useState } from 'react'
import BudgetCard from '../components/BudgetCard'

function Budgets() {

  const [ budgets, setBudgets ] = useState([
    { id: 1, name: 'Monthly', amount: 5000, spent: 1800 },
    { id: 2, name: 'Food', amount: 800, spent: 600 },
    { id: 3, name: 'Transport', amount: 500, spent: 400 },
  ])

  const [newBudget, setNewBudget ] = useState({ name: '', amount: '' })

  const handleAddBudget = (e) => {
    e.preventDefault()
    const budget = {
      id: budget.length + 1,
      name: newBudget.name,
      amount: parseFloat(newBudget.amount),
      spent: 0
    }
    setBudgets([...budgets, budget])
    setNewBudget({ name: '', amount: '' })
  }

  return (
    <div className='budget-page'>
      <h1>Manage budgets</h1>

      <div className='budget-grid'>
        {budgets.map(budget => (
          <BudgetCard 
            key={budget.id}
            title={budget.name}
            // value=(budget.amount)
            spent={budget.spent}
            showProgress
            editable
          />
        ))}
      </div>

      <div className='add-budget-form'>
        <h3>Add New Budget</h3>
        <form onSubmit={handleAddBudget}>
          <input 
            type='text'
            placeholder='Budget name'
            value={newBudget.name}
            onChange={(e) => setNewBudget({...newBudget, name: e.target.value})}
            required
          />
          <input 
            type='Number'
            placeholder='Amount'
            value={newBudget.amount}
            onChange={(e) => setNewBudget({...newBudget, amount: e.target.value})}
            required
            min='0'
            step='0.01'
          />
          <button type='submit'>Add Budget</button>
        </form>
      </div>

    </div>
  )
}

export default Budgets
