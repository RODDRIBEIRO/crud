/* eslint-disable indent */
import axios from 'axios'

const urlAPI = `/crud/clientes`

const getAllClientes = ({ commit }) => {
    return axios.get(urlAPI)
        .then((res) => {
            commit('SET_LIST_CLIENTES', res.data)
            return res.data
        }).catch(err => {
            console.error(err)
            throw new Error(err)
        })
}

const deletarCliente = ({ commit, rootState }, cliente) => {
    return axios.delete(urlAPI, {
        data: cliente
    })
        .then((res) => {
            return res
        }).catch(err => {
            return err
        })
}

const cadastrarCliente = ({ commit }, cliente) => {
    commit('cadastrarCliente', cliente)
}

export {
    cadastrarCliente,
    deletarCliente,
    getAllClientes
}
