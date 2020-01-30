/* eslint-disable indent */
const cadastrarCliente = (state, cliente) => {
    state.cliente.push(cliente)
}

const SET_LIST_CLIENTES = (state, data) => {
    state.cliente = data
}

export {
    cadastrarCliente,
    SET_LIST_CLIENTES
}
