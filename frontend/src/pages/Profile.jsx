import React from 'react'


export default function Profile() {
    return (
        <div className="min-h-screen bg-slate-900 px-4 py-8">
            <div className="max-w-3xl mx-auto">
                <h2 className="text-4xl font-extrabold text-white mb-8 tracking-wide">
                    Meu <span className="text-purple-400">Perfil</span>
                </h2>
                
                <div className="bg-white/10 backdrop-blur-lg border border-white/20 shadow-2xl rounded-2xl p-8">
                    <h3 className="text-xl font-semibold text-white mb-4 border-b border-white/20 pb-2">Detalhes Pessoais</h3>
                    
                    <div className="space-y-4 text-slate-200">
                        <p><strong>Nome:</strong> João da Silva</p>
                        <p><strong>Email:</strong> joao.personal@fitcoach.com</p>
                        <p><strong>Especialidade:</strong> Treinamento Funcional e HIIT</p>
                        <p><strong>Membros Ativos:</strong> 42</p>
                    </div>

                    <button
                        className="mt-6 py-2 px-4 rounded-lg bg-purple-500 hover:bg-purple-400 text-white
                        font-semibold transition-all duration-300 shadow-lg hover:shadow-purple-500/40"
                    >
                        Editar Informações
                    </button>
                </div>
            </div>
        </div>
    )
}