import React from 'react'
import {PieChart as RechartsPieChart, Cell, Legend, Pie, Tooltip } from 'recharts'

const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042', '#8884D8']

function PieChart({ data }) {

  return (
    <RechartsPieChart width={400} height={400}>
      <Pie
        data={data}
        cx='50%'
        cy='50%'
        labelLine={false}
        outerRadius={150}
        fill='#8884d8'
        dataKey='value'
        label={({ name, percent }) => `${name}: R{(percent * 100).toFixed(0)}%`}
      >
        {data.map((entry, index) => (
          <Cell key={`cell-R{index}`} fill={COLORS[index % COLORS.length]} />
        ))}
      </Pie>
      <Tooltip />
      <Legend />
    </RechartsPieChart>
  )
}

export default PieChart
