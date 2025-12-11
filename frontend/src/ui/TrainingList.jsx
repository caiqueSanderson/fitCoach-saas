import React from 'react'

const trainings = [
    { id: 1, title: 'Força - Semana 1', students: 12 },
    { id: 2, title: 'Ganho de Massa - Semana 3', students: 8 }
]

export default function TrainingList() {
    return (
        <div className="text-white"> 
            {/* <h3 className="text-xl font-semibold mb-4 text-teal-400">Treinos Ativos</h3> */}
            
            <ul className="space-y-3">
                {trainings.map(t => (
                    <li 
                        key={t.id} 
                        className="flex items-center justify-between p-4 bg-white/5 hover:bg-white/10 rounded-lg transition-all border-b border-white/10"
                    >
                        <div>
                            <div className="font-semibold text-lg text-white">{t.title}</div>
                      
                            <div className="text-sm text-slate-300 mt-0.5">
                                Alunos Ativos: <span className="text-teal-400 font-bold">{t.students}</span>
                            </div>
                        </div>
                        
                        <div>
                            <button 
                                className="px-4 py-2 rounded-full 
                                    bg-teal-500 hover:bg-teal-400 text-white font-medium 
                                    text-sm transition-colors shadow-md hover:shadow-teal-500/40"
                            >
                                Detalhes
                            </button>
                        </div>
                    </li>
                ))}
            </ul>
            
            <div className="mt-6 text-center border-t border-white/10 pt-4">
                <button 
                    className="text-sm text-slate-300 hover:text-purple-400 transition-colors"
                >
                    Ver Todos os Treinos
                </button>
            </div>
        </div>
    )
}