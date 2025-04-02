import React, { useState } from 'react'
import Sidebar from './Sidebar'
import { FiBell, FiMenu } from 'react-icons/fi'

function Navbar() {

    const [sidebarOpen, setSidebarOpen] = useState(false)

    return (
        <div className='navbar'>
            <nav className='mobile-menu'>
            <button onClick={() => setSidebarOpen(!sidebarOpen)}>
                <FiMenu size={24} />
            </button>
            <h1>Budget Managment Systems</h1>
            </nav>
            <div className='notifications'>
                <FiBell size={24} />
            </div>
        </div>
    )
}

export default Navbar
