<template>
  <div>
    <q-page
      padding
      class="q-pt-xl"
    >
      <q-card class="my-card">
        <q-card-section>
          <div class="text-h6 q-mb-sm">
            <q-icon name="search" /> Pesquisa de Cliente</div>
          <q-separator class="q-mb-lg" />
        </q-card-section>
        <q-card-section class="text-white q-gutter-lg flex">
          <q-input
            outlined
            placeholder="Buscar..."
            style="flex:8"
          >
            <template v-slot:prepend>
              <q-icon name="search" />
            </template>
          </q-input>
          <q-btn
            color="negative"
            icon="add_circle"
            label="Cadastrar"
            style="flex:1"
            to="/cliente/novo"
          />
        </q-card-section>
      </q-card>
      <div class="q-mt-md">
        <q-table
          :data="data"
          :columns="columns"
          title="Lista de Clientes"
          row-key="id"
        >
          <template v-slot:body="props">
            <q-tr :props="props">
              <q-td
                key="id"
                :props="props"
              >
                {{ props.row.id}}
              </q-td>
              <q-td
                key="nome"
                :props="props"
              >
                {{ props.row.nome }}
              </q-td>
              <q-td
                key="estado"
                :props="props"
              >
                <div
                  v-for="(l, i) in props.row.enderecos"
                  :key="i"
                >
                  <div
                    v-for="(j, l) in l.estado"
                    :key="l"
                  >
                    {{
                   j.descricao
                   }}
                  </div>
                </div>
              </q-td>
            </q-tr>
          </template>
        </q-table>
      </div>
    </q-page>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
const columns = [
  { name: 'id', align: 'left', label: 'ID', field: '' },
  { name: 'nome', align: 'left', label: 'Nome', field: '' },
  { name: 'estado', align: 'left', label: 'Estado', field: '' },
  { name: 'excluir', align: 'right', label: 'Excluir', field: 'excluir' }
]
export default {
  data () {
    return {
      data: [],
      columns
    }
  },
  computed: {
    ...mapGetters('cliente', ['getStateClientes'])
  },
  methods: {
    ...mapActions('cliente', ['getAllClientes'])
  },
  async mounted () {
    await this.getAllClientes()
    this.data = this.getStateClientes
  }
}
</script>
