import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Router from './routes/Router'


export default function App() {
  return (
    <div className="min-h-screen">
      <Router />
    </div>
  )
}
