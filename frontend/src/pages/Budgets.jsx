import React, { useContext, useEffect, useState } from 'react'
import BudgetCard from '../components/BudgetCard'
import { createBudget, deleteBudget, getBudgets } from '../services/budgetService'
import { useNavigate } from "react-router"
import { useAuth } from '../context/AuthContext'

function Budgets() {

  const [ budgets, setBudgets ] = useState([
    // { id: 1, name: 'Monthly', amount: 5000, spent: 1800 },
    // { id: 2, name: 'Food', amount: 800, spent: 600 },
    // { id: 3, name: 'Transport', amount: 500, spent: 400 },
  ])
  const [newBudget, setNewBudget ] = useState({ name: '', amount: '' })
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const {isAuthenticated} = useContext(useAuth)
  const navigate = useNavigate()

  useEffect(() => {
    if(!isAuthenticated) {
      navigate('/login')
      return
    }

    const fetchBudgets = async () => {
      try {
        const data = await getBudgets() /** service method */
        setBudgets(data)
      } catch (err) {
        setError(err.message)
      } finally {
        setLoading(false)
      }
    }
    fetchBudgets()
  },[isAuthenticated, navigate])

  const handleAddBudget = async(e) => {
    e.preventDefault()
    try {
      const budgetCreated = await createBudget(newBudget)
      setBudgets([...budgets, budgetCreated])
      setNewBudget({ name: '', amount: '', category: '' })
    } catch (err) {
      setError(err.message)
    }
  }

  const handleDeleteBudget = async(id) => {
    try {
      await deleteBudget(id)
      setBudgets(budgets.filter(budget => budget.id !== id))
    } catch (err) {
      setError(err.message)
    }
  }

  if(loading) return <div>Loading budgets...</div>
  if(error) return <div>Error: {error}</div>

  return (
    <div className='budget-page'>
      <h1>Manage budgets</h1>

      <div className='budget-grid'>
        {budgets.map(budget => (
          <BudgetCard 
            key={budget.id}
            budget={budget}
            onDelete={() => handleDeleteBudget(budget.id)}
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
          <input 
            type='text'
            placeholder='Category'
            value={newBudget.category}
            onChange={(e) => setNewBudget({...newBudget, category: e.target.value})}
          />
          <button type='submit'>Add Budget</button>
        </form>
      </div>

    </div>
  )
}

export default Budgets
