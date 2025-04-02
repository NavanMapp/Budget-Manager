import { BrowserRouter, Route, Router, Routes } from 'react-router-dom'
import './App.css';
import Navbar from './components/Navbar';
import Sidebar from './components/Sidebar';
import Dashboard from './pages/Dashboard';
import Budgets from './pages/Budgets';
import Reports from './pages/Reports';
import Categories from './pages/Categories';
import Settings from './pages/Settings';
import { useState } from 'react';

function App() {

  const [sidebarOpen, setSidebarOpen] = useState(false)
  return (
    <BrowserRouter>
      <div className='app'>
        <Navbar 
          onMenuClick={() => setSidebarOpen(!sidebarOpen)}
        />
        <div className='main-content'>
          <Sidebar 
            isOpen={sidebarOpen}
            onClose={() => setSidebarOpen(false)}
          />
          <div className='content'>
            <Routes>
              <Route path='/' element={<Dashboard />} />
              <Route path='/budgets' element={<Budgets />} />
              <Route path='/reports' element={<Reports />} />
              <Route path='/categories' element={<Categories />} />
              <Route path='settings' element={<Settings />} />
            </Routes>
          </div>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
