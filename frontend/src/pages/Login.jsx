import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../services/auth'

export default function Login() {
    const [mode, setMode] = useState('trainee')  // 'trainee' | 'personal'
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [token, setToken] = useState('')
    const [loading, setLoading] = useState(false)

    const { login, loginTrainee } = useAuth()
    const navigate = useNavigate()

    async function handleSubmit(e) {
        e.preventDefault()
        setLoading(true)

        try {
            if (mode === 'personal') {
                await login({ email, password })
            } else {
                await loginTrainee(token)
            }
            navigate('/')
        } catch (err) {
            alert('Credenciais inválidas')
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-slate-900 via-slate-800 to-slate-900 px-4">
            <div className="w-full max-w-md bg-white/10 backdrop-blur-xl border border-white/20 shadow-2xl rounded-2xl p-8">

                <div className="text-center mb-8">
                    <h1 className="text-3xl font-extrabold text-white tracking-wider">
                        Fit<span className="text-teal-400">Coach</span>
                    </h1>
                    <p className="text-slate-300 mt-2 text-sm">
                        Performance • Saúde • Evolução
                    </p>
                </div>

                <div className="flex items-center justify-center mb-6">
                    <div className="bg-white/20 backdrop-blur-md rounded-full p-1 flex w-64">
                        <button
                            className={`flex-1 px-4 py-2 rounded-full text-sm font-semibold transition-all
                                ${mode === 'trainee' ? 'bg-teal-500 text-white' : 'text-slate-200'}`}
                            onClick={() => setMode('trainee')}
                        >
                            Trainee
                        </button>
                        <button
                            className={`flex-1 px-4 py-2 rounded-full text-sm font-semibold transition-all
                                ${mode === 'personal' ? 'bg-purple-500 text-white' : 'text-slate-200'}`}
                            onClick={() => setMode('personal')}
                        >
                            Personal
                        </button>
                    </div>
                </div>

                <form onSubmit={handleSubmit}>

                    {mode === 'personal' && (
                        <>
                            <label className="block mb-2 text-sm font-medium text-slate-200">
                                Email
                            </label>
                            <input
                                value={email}
                                onChange={e => setEmail(e.target.value)}
                                className="w-full p-3 rounded-lg bg-white/20 text-white border border-white/30
                                placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-teal-400 mb-5"
                                placeholder="seuemail@exemplo.com"
                            />

                            <label className="block mb-2 text-sm font-medium text-slate-200">
                                Senha
                            </label>
                            <input
                                type="password"
                                value={password}
                                onChange={e => setPassword(e.target.value)}
                                className="w-full p-3 rounded-lg bg-white/20 text-white border border-white/30
                                placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-teal-400 mb-6"
                                placeholder="••••••••"
                            />
                        </>
                    )}

                    {mode === 'trainee' && (
                        <>
                            <label className="block mb-2 text-sm font-medium text-slate-200">
                                CPF
                            </label>
                            <input
                                value={token}
                                onChange={e => setToken(e.target.value)}
                                className="w-full p-3 rounded-lg bg-white/20 text-white border border-white/30
                                placeholder-slate-300 focus:outline-none focus:ring-2 focus:ring-purple-400 mb-5"
                                placeholder="Insira seu CPF aqui"
                            />
                        </>
                    )}

                    <button
                        type="submit"
                        className="w-full py-3 rounded-lg bg-teal-500 hover:bg-teal-400 text-white
                        font-semibold tracking-wide transition-all duration-300 shadow-lg
                        hover:shadow-teal-500/40 disabled:opacity-50"
                        disabled={loading}
                    >
                        {loading ? 'Carregando...' : 'Entrar'}
                    </button>
                </form>
            </div>
        </div>
    )
}
