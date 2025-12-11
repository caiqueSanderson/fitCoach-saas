import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Home from '../pages/Home'
import Login from '../pages/Login'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'
import Trainee from '../pages/Trainee'
import TraineeDetails from '../pages/TraineeDetails'
import CreateWorkout from '../pages/CreateWorkout'

import { useAuth } from '../services/auth'
import Layout from '../components/Layout'


export default function Router() {
    const { isAuthenticated } = useAuth()


    return (
        <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/" element={<Home />} />
            <Route
                path="/dashboard"
                element={
                    // isAuthenticated ? <Layout><Dashboard /></Layout> : <Navigate to="/login" replace />
                    <Layout><Dashboard /></Layout>
                }
            />
            <Route
                path="/profile"
                element={
                    // isAuthenticated ? <Layout><Profile /></Layout> : <Navigate to="/login" replace />
                    <Layout>
                        <Profile />
                    </Layout>
                }
            />
            <Route path="/trainee"
                element={
                    <Layout>
                        <Trainee />
                    </Layout>}
            />
            <Route path="/trainee/:id" element={<Layout > <TraineeDetails /> </Layout>} />
            <Route path="/create-workout/:id" element={<Layout ><CreateWorkout /></Layout>} />
            <Route path="*" element={<Navigate to={isAuthenticated ? '/' : '/login'} replace />} />
        </Routes>
    )
}