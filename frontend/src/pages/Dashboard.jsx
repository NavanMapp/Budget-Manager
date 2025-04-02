import React from 'react'
import Categories from './Categories'
import BudgetCard from '../components/BudgetCard'
import PieChart from '../components/PieChart'
import BarChart from '../components/BarChart'

function Dashboard() {

  const budgetData = {
    totalBudget: 5000,
    remaining: 3200,
    spent: 1800,
    byCategory: [
      { name: 'Food', value: 600 },
      { name: 'Transport', value: 400 },
      { name: 'Entertainment', value: 300 },
      { name: 'Utilities', vlaue: 500 },
    ]
  }

  const recentExpenses = [
    { id: 1, category: 'Food', amount: 50, date: '2023-05-15', status: 'approved' },
    { id: 2, category: 'Transport', amount: 30, date: '2024-05-14', status: 'approved' },
  ]

  return (
    <div className='dashboard'>
      <h1>Budget Overview</h1>
      <div className='summary-cards'>
        <BudgetCard title='Total Budget' value={budgetData.totalBudget} />
        <BudgetCard title='Remaining' value={budgetData.remaining} type='success' />
        <BudgetCard title='Spent' value={budgetData.spent} type='danger' />
      </div>
      <div className='chart-row'>
        <div className='chart-container'>
          <h3>Spending by Category</h3>
          <PieChart data={budgetData.byCategory}/>
        </div>
        <div className='chart-container'>
          <h3>Monthly Spending Trend</h3>
          <BarChart data={{}} />
        </div>
        <div className='recent-expenses'>
          <h3>Recent Expenses</h3>
          <table>
            <thead>
              <th>Category</th>
              <th>Amount</th>
              <th>Date</th>
              <th>Status</th>
            </thead>
            <tbody>
              {recentExpenses.map(expense => (
                <tr key={expense.id}>
                  <td>{expense.department}</td>
                  <td>{expense.category}</td>
                  <td>{expense.amount}</td>
                  <td>{expense.date}</td>
                  <td>{expense.status}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

      </div>


    </div>
  )
}

export default Dashboard
