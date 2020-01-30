/* eslint-disable indent */
import axios from 'axios'

const urlAPI = `localhost:8080/clientes`

const getAllClientes = ({ commit }, params) => {
    console.log(params)
    return axios.get(urlAPI, {
        params: params
    })
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
