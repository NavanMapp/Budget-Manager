import React from 'react'
import api from './api'

export const getBudgets = async () => {
    const response = await api.get('/budgets')
    return response.data
}

export const createBudget = async (budgetData) => {
    const response = await api.post('/budgets', budgetData)
    return response.data
}

export const updateBudget = async (id, budgetData) => {
    const response = await api.put(`/budgets/${id}`)
    return response.data
}

export const deleteBudget = async (id) => {
    const response = await api.delete(`/budgets/${id}`)
    return response.data
}

function budgetService() {
    return (
    <div>
    </div>
  )
}

export default budgetService
