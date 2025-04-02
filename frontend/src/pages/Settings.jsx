import React, { useState } from 'react'

function Settings() {

  const [settings, setSettings] = useState({
    currency: 'ZAR',
    monthlyBudget: 5000,
    notifications: true,
  })

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target
    setSettings({
      ...settings,
      [name]: type === 'checkbox' ? checked : value
    })
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    alert('settings saved: ', settings)
  }

  return (
    <div className='settings-page'>
      <h1>Settings</h1>

      <form onSubmit={handleSubmit}>
        <div className='form-group'>
          <label>Currency</label>
          <select
            name='currency'
            value={settings.currency}
            onChange={handleChange}
          >
            <option value='ZAR'>ZAR (R)</option>
          </select>
        </div>

        <div className='form-group'>
          <label>Default Monthly Budget</label>
          <input 
            type='number'
            name='monthlyBudget'
            value={settings.monthlyBudget}
            onChange={handleChange}
            min='0'
            step='0.01'
          />
        </div>
        <div className='form-group checkbox'>
          <label>
            <input
              type='checkbox'
              name='notifications'
              checked={settings.notifications}
              onChange={handleChange}
            />
            Enable Notifications
          </label>
        </div>

        <button type='submit' className='save-btn'>Save Settings</button>
      </form>
    </div>
  )
}

export default Settings
