import React from 'react'
import StatCard from '../ui/StatCard'
import TrainingList from '../ui/TrainingList'


export default function Dashboard() {
    return (
        <div className="min-h-screen bg-slate-900 px-4 py-8"> 
            <div className="max-w-7xl mx-auto">
                <h2 className="text-4xl font-extrabold text-white mb-8 tracking-wide">
                    Visão Geral do <span className="text-teal-400">Dashboard</span>
                </h2>
                
                <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
                    <StatCard title="Alunos Ativos" value="42" color="teal" />
                    <StatCard title="Treinos Agendados" value="8" color="purple" />
                    <StatCard title="Próximas Consultas" value="3" color="sky" />
                </div>
                
                <div className="bg-white/10 backdrop-blur-lg border border-white/20 shadow-2xl rounded-2xl p-6">
                    <h3 className="text-2xl font-semibold text-white mb-4">Treinos em Andamento</h3>
                    <TrainingList />
                </div>
            </div>
        </div>
    )
}