import React from 'react'
import { Link } from 'react-router-dom'


export default function Home() {
    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-slate-900 via-slate-800 to-slate-900 px-4">
            <div className="w-full max-w-xl bg-white/10 backdrop-blur-xl border border-white/20 shadow-2xl rounded-2xl p-10 text-center">
                
                <h1 className="text-5xl font-extrabold text-white tracking-wider mb-4">
                    Bem-vindo, <span className="text-teal-400">Personal!</span>
                </h1>
                
                <p className="text-slate-300 text-lg mb-8">
                    Seu painel completo para gerenciar treinos, alunos e agendamentos de forma eficiente.
                </p>
                
                <div className="mt-8">
                    <Link 
                        to="/dashboard" 
                        className="inline-flex items-center justify-center 
                            px-8 py-3 bg-teal-500 hover:bg-teal-400 text-white font-bold 
                            rounded-lg text-lg transition-all duration-300 shadow-lg 
                            hover:shadow-teal-500/40"
                    >
                        Acessar o Dashboard
                        <svg className="ml-2 w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M17 8l4 4m0 0l-4 4m4-4H3"></path></svg>
                    </Link>
                </div>
            </div>
        </div>
    )
}