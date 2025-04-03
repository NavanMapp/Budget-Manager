import React, { createContext, useContext, useEffect, useState } from 'react'
import { getCurrentUser } from '../services/authService'

const AuthContext = createContext()

export const AuthProvider = ({ children }) => {

    const [user, setUser] = useState(null)
    const [isAuthenticated, setIsAuthenticated] = useState(false)
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        const checkAuth = async() => {
            try {
                const token = localStorage.getItem('token')
                if (token) {
                    const userData = await getCurrentUser()
                    setUser(userData)
                    setIsAuthenticated(true)
                }
            } catch (err) {
                alert('Auth check failed', err)
            }finally {
                setLoading(false)
            }
        }

        checkAuth()
    }, [])

    const login = async (userData) => {
        const data = await login(userData)
        setUser(data.user)
        setIsAuthenticated(true)
        return data
    }

    const logout = () => {
        localStorage.removeItem('token')
        setUser(null)
        setIsAuthenticated(false)
    }

  return (
    <AuthContext.Provider
        value={{
            user,
            isAuthenticated,
            loading,
            login,
            logout
        }}
    >
      {children}
    </AuthContext.Provider>
  )
}

export const useAuth = () => useContext(AuthContext)
