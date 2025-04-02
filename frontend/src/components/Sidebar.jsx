import React from 'react'
import { useLocation } from 'react-router-dom'
import { FiDollarSign, FiHome, FiSettings, FiTag } from 'react-icons/fi'

function Sidebar({ isOpen, onClose }) {

  const location = useLocation()

  return (
    <div className={`sidebar ${isOpen ? 'open' : ''}`}>
      <ul>
        <li>
          <a
            href='/'
            className={location.pathname === '/' ? 'active' : ''}
            onClick={onClose}
          >
            <FiHome />Dashboard
          </a>
        </li>
        <li>
          <a
            href='/budgets'
            className={location.pathname === '/budgets' ? 'active' : ''}
            onClick={onClose}
          >
            <FiDollarSign />Budgets
          </a>
        </li>
        <li>
          <a
            href='/categories'
            className={location.pathname === '/categories' ? 'active' : ''}
            onClick={onClose}
          >
            <FiTag />Categories
          </a>
        </li>
        <li>
          <a
            href='/settings'
            className={location.pathname === '/settings' ? 'active' : ''}
            onClick={onClose}
          >
            <FiSettings />Settings
          </a>
        </li>
      </ul>
    </div>
  )
}

export default Sidebar
