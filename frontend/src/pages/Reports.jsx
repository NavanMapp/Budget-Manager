import React from 'react'
import LineChart from '../components/LineChart'
import PieChart from '../components/PieChart'

function Reports() {

  const monthlyData = [
    { month: 'Jan', spent: 1200, budget: 1500 },
    { month: 'Feb', spent: 1800, budget: 1500 },
    { month: 'Mar', spent: 900, budget: 1500 },
    { month: 'Apr', spent: 1500, budget: 1500 },
    { month: 'May', spent: 2000, budget: 1500 },
  ]

  const category = [
    { name: 'Food', value: 600 },
    { name: 'Transport', value: 400 },
    { name: 'Entertainment', value: 300 },
    { name: 'Utilities', value: 500 },
  ]

  return (
    <div className='report-page'>
      <h1>Financial Reports</h1>

      <div className='report-section'>
        <h2>Monthly Spending vs Budget</h2>
        <LineChart data={monthlyData} />
      </div>
      
      <div className='report-section'>
        <h2>Category Distribution</h2>
        <PieChart data={monthlyData} />
      </div>
      
      <div className='report-section'>
        <h2>Export Data</h2>
        <button className='export-btn'>Export to CSV</button>
        <button className='export-btn'>Export to PDF</button>
      </div>
      
    </div>
  )
}

export default Reports
