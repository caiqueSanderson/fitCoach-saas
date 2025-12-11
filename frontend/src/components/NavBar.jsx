import React from 'react'
import { Link } from 'react-router-dom'

export default function NavBar() {
    return (
        <header className="sticky top-0 z-10 
            bg-slate-900/60 backdrop-blur-lg border-b border-white/10 
            px-6 py-4 shadow-xl">
            
            <div className="max-w-7xl mx-auto flex items-center justify-between">
                <div className="flex items-center gap-4">
                    <Link to="/" className="text-2xl font-extrabold text-white tracking-wider">
                        Fit<span className="text-teal-400">Coach</span>
                    </Link>
                    <span className="hidden sm:inline text-sm text-slate-400">| Painel Administrativo</span>
                </div>
                
                <div className="flex items-center gap-4">
                    <button className="px-3 py-1 rounded-full text-sm text-slate-300 hover:text-teal-400 transition-colors">
                        Suporte
                    </button>
                    <button className="px-4 py-2 rounded-full bg-purple-500 hover:bg-purple-400 text-white font-semibold text-sm transition-colors shadow-md">
                        Sair
                    </button>
                </div>
            </div>
        </header>
    )
}