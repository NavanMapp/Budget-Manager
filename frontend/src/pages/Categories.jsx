import React, { useState } from 'react'

function Categories() {

  const [ categories, setCategories ] = useState([
    { id: 1, name: 'Food', monthlyBudget: 800 },
    { id: 2, name: 'Transport', monthlyBudget: 500 },
    { id: 3, name: 'Entertainment', monthlyBudget: 300 },
  ])

  const [newCategory, setNewCategory] = useState({ name:'', monthlyBudget:''})

  const handleAddCategory = (e) => {
    e.preventDefault()
    const category = {
      id: categories.length + 1,
      name: newCategory.name,
      monthlyBudget: parseFloat(newCategory.monthlyBudget)
    }
    setCategories([...categories, category])
    setNewCategory({name:'', monthlyBudget:''})
  }

  return (
    <div>
      <h1>Manage Categories</h1>

      <div className='category-list'>
        <table>
          <thead>
            <tr>
              <th>Category</th>
              <th>Monthly Budget</th>
              <th>Actions</th>
            </tr>
            <tbody>
              {categories.map(cat => (
                <tr key={cat.id}>
                  <td>{cat.name}</td>
                  <td>{cat.name}</td>
                  <td>R{cat.monthlyBudget}</td>
                  <td>
                    <button className='edit-btn'>Edit</button>
                    <button className='delete-btn'>Delete</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </thead>
        </table>
      </div>
      <div className='add-category-form'>
        <h3>Add New Category</h3>
        <form onSubmit={handleAddCategory}>
          <input 
            type='text'
            placeholder='Category name'
            value={newCategory.name}
            onChange={(e) => setNewCategory({...newCategory, monthlyBudget: e.target.value})}
            required
          />
          <input 
            type='number'
            placeholder='Monthly budget'
            value={newCategory.monthlyBudget}
            onChange={(e) => setNewCategory({...newCategory, monthlyBudget: e.target.value})}
            required
            min='0'
            step='0.01'
          />
          <button type='submit'>Add Category</button>
        </form>
      </div>
    </div>
  )
}

export default Categories
