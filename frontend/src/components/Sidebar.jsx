import React from 'react'
import { NavLink } from 'react-router-dom'


const NavItem = ({ to, children }) => (
    <NavLink
        to={to}
        className={({ isActive }) =>
            `block px-4 py-2 rounded-lg font-medium transition-all duration-200 
            ${isActive
                ? 'bg-teal-500 text-white shadow-md hover:bg-teal-400'
                : 'text-slate-200 hover:bg-white/10 hover:text-white'
            }`
        }
    >
        {children}
    </NavLink>
)


export default function Sidebar() {
    return (
        <aside className="w-64 bg-slate-900 border-r border-white/10 hidden md:block shadow-2xl">
            <div className="p-6">
                <div className="mb-8 border-b border-white/10 pb-4">
                    <div className="text-2xl font-extrabold text-white tracking-wider">
                        Fit<span className="text-teal-400">Coach</span>
                    </div>
                    <div className="text-xs text-slate-400 mt-1">Painel administrativo</div>
                </div>

                <nav className="space-y-3">
                    <NavItem to="/dashboard">
                        <div className="flex items-center gap-3">
                            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l-2-2m-2 2v10a1 1 0 01-1 1h-3"></path></svg>
                            Dashboard
                        </div>
                    </NavItem>
                    <NavItem to="/profile">
                        <div className="flex items-center gap-3">
                            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path></svg>
                            Perfil
                        </div>
                    </NavItem>
                    <NavItem to="/trainee">
                        <div className="flex items-center gap-3">
                            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                    d="M17 20h5v-2a4 4 0 00-4-4h-1M9 20H4v-2a4 4 0 014-4h1m6-6a4 4 0 11-8 0 4 4 0 018 0z" />
                            </svg>
                            Trainee
                        </div>
                    </NavItem>

                </nav>
            </div>
        </aside>
    )
}