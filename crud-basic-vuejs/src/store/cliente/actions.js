/* eslint-disable indent */
import axios from 'axios'

const urlAPI = `/crud/clientes`

const getAllClientes = ({ commit }, params) => {
    return axios.get(urlAPI)
        .then((res) => {
            commit('SET_LIST_CLIENTES', res.data)
            return res.data
        }).catch(err => {
            console.error(err)
            throw new Error(err)
        })
}

const cadastrarCliente = ({ commit }, cliente) => {
    commit('cadastrarCliente', cliente)
}

export { cadastrarCliente, getAllClientes }
