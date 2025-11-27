import React from 'react'
import { NavLink } from 'react-router-dom'


const Link = ({ to, children }) => (
    <NavLink
        to={to}
        className={({ isActive }) =>
            `block px-4 py-2 rounded-md text-sm ${isActive ? 'bg-sky-100 text-sky-700' : 'text-slate-700 hover:bg-slate-100'}`
        }
    >
        {children}
    </NavLink>
)


export default function Sidebar() {
    return (
        <aside className="w-64 bg-white border-r hidden md:block">
            <div className="p-6">
                <div className="mb-6">
                    <div className="text-lg font-semibold">FitCoach</div>
                    <div className="text-xs text-slate-500">Painel administrativo</div>
                </div>
                <nav className="space-y-1">
                    <Link to="/">Dashboard</Link>
                    <Link to="/profile">Perfil</Link>
                </nav>
            </div>
        </aside>
    )
}