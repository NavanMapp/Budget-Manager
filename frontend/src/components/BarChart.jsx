import React from 'react'
import { Bar, CartesianGrid, Legend, BarChart as RechartBarChart, Tooltip, XAxis, YAxis } from 'recharts'

function BarChart({ data }) {
  return (
    <RechartBarChart
      width={500}
      height={300}
      data={data}
      margin={{
        top:5,
        right:30,
        left:20,
        bottom:5
      }}
    >
      <CartesianGrid strokeDasharray='3 3' />
      <XAxis dataKey='month' />
      <YAxis />
      <Tooltip />
      <Legend />
      <Bar dataKey='spent' fill='#8884d8' name='Spent' />
      <Bar dataKey='budget' fill='#82ca9d' name='Budget' />
    </RechartBarChart>
  )
}

export default BarChart
