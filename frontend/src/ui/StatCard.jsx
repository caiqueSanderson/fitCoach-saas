import React from 'react'


export default function StatCard({ title, value, color }) {
    const colorClass = color === 'teal' ? 'text-teal-400' : 
                       color === 'purple' ? 'text-purple-400' : 
                       'text-sky-400';

    return (
        <div className="bg-white/10 backdrop-blur-md border border-white/20 shadow-xl rounded-2xl p-6 transition-all hover:bg-white/20">
            <p className="text-sm font-medium text-slate-300 mb-1">{title}</p>
            <p className={`text-4xl font-bold ${colorClass}`}>{value}</p>
        </div>
    )
}