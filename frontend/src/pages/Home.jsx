import React from 'react'
import { Link } from 'react-router-dom'


export default function Home() {
    return (
        <div className="max-w-4xl mx-auto py-12">
            <h2 className="text-2xl font-semibold mb-4">Bem-vindo ao FitCoach</h2>
            <p className="text-slate-600">Painel do instrutor — veja treinos, alunos e agendamentos.</p>
            <div className="mt-6">
                <Link to="/" className="px-4 py-2 bg-sky-600 text-white rounded">Ir para Dashboard</Link>
            </div>
        </div>
    )
}