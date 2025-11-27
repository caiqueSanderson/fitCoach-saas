import { useState } from 'react'
import api from './api'


let _auth = { token: null, role: null }


export function useAuth() {
    const [isAuthenticated, setIsAuthenticated] = useState(!!_auth.token)


    async function login({ email, password }) {
        const res = await api.post('/auth/instructor/login', { email, password })
        _auth.token = res.data.token
        _auth.role = "PERSONAL"
        setIsAuthenticated(true)
        return res
    }

    async function loginTrainee(token) {
        const res = await api.post('/auth/trainee/login', { token })
        _auth.token = token
        _auth.role = "TRAINEE"
        setIsAuthenticated(true)
        return res
    }


    function logout() {
        _auth.token = null
        setIsAuthenticated(false)
    }


    return { isAuthenticated, login, loginTrainee, logout }
}