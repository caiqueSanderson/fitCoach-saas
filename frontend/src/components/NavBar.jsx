import React from 'react'

export default function NavBar() {
    return (
        <header className="border-b bg-white px-6 py-4 shadow-sm">
            <div className="max-w-7xl mx-auto flex items-center justify-between">
                <div className="flex items-center gap-3">
                    <h1 className="text-xl font-semibold">FitCoach</h1>
                    <span className="text-sm text-slate-500">Painel</span>
                </div>
                <div className="flex items-center gap-4">
                    <button className="px-3 py-1 rounded-md text-sm">Suporte</button>
                    <button className="px-3 py-1 rounded-md bg-slate-100 text-sm">Sair</button>
                </div>
            </div>
        </header>
    )
}