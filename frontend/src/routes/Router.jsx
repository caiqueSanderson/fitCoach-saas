import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Home from '../pages/Home'
import Login from '../pages/Login'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'
import { useAuth } from '../services/auth'
import Layout from '../components/Layout'


export default function Router() {
const { isAuthenticated } = useAuth()


return (
<Routes>
<Route path="/login" element={<Login />} />
<Route
path="/"
element={isAuthenticated ? <Layout><Dashboard /></Layout> : <Navigate to="/login" replace />}
/>
<Route
path="/profile"
element={isAuthenticated ? <Layout><Profile /></Layout> : <Navigate to="/login" replace />}
/>
<Route path="*" element={<Navigate to={isAuthenticated ? '/' : '/login'} replace />} />
</Routes>
)
}