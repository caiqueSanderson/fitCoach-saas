import React from 'react'
import StatCard from '../ui/StatCard'
import TrainingList from '../ui/TrainingList'


export default function Dashboard() {
    return (
        <div className="max-w-7xl mx-auto">
            <h2 className="text-2xl font-semibold mb-6">Dashboard</h2>
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mb-6">
                <StatCard title="Alunos" value="42" />
                <StatCard title="Treinos ativos" value="8" />
                <StatCard title="Proximos agendamentos" value="3" />
            </div>
            <TrainingList />
        </div>
    )
}