import React from 'react'
import NavBar from './NavBar'
import Sidebar from './Sidebar'

export default function Layout({ children }) {
    return (
        <div className="flex min-h-screen bg-gradient-to-br from-slate-900 via-slate-800 to-slate-900">
            <Sidebar />
            <div className="flex-1">
                <NavBar />
                <main className="p-6">{children}</main>
            </div>
        </div>
    )
}