import React from 'react'

const trainings = [
    { id: 1, title: 'Força - Semana 1', students: 12 },
    { id: 2, title: 'Ganho de Massa - Semana 3', students: 8 }
]

export default function TrainingList() {
    return (
        <div className="bg-white p-4 rounded shadow">
            <h3 className="text-lg font-medium mb-3">Treinos</h3>
            <ul className="space-y-3">
                {trainings.map(t => (
                    <li key={t.id} className="flex items-center justify-between">
                        <div>
                            <div className="font-medium">{t.title}</div>
                            <div className="text-sm text-slate-500">Alunos: {t.students}</div>
                        </div>
                        <div>
                            <button className="px-3 py-1 rounded bg-sky-600 text-white text-sm">Ver</button>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    )
}