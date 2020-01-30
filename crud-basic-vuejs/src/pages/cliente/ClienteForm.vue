<template>
  <q-page padding>
    <q-card class="my-card">
      <q-card-section>
        <div class="text-h5 q-mb-sm">
          <q-icon name="library_add" /> Cadastrar Cliente</div>
        <q-separator class="q-mb-lg" />
      </q-card-section>
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-gutter-md"
      >
        <q-card-section>
          <div class="row justify-around col q-pr-lg">
            <q-input
              outlined
              label="Nome"
              subtitle="Nome do Cliente"
              v-model="cliente.nome"
              style="flex:8"
              lazy-rules
              :rules="[ val => val && val.length > 0|| 'Por favor insira o nome do cliente']"
            >
              <template v-slot:prepend>
                <q-icon name="search" />
              </template>
            </q-input>
          </div>
        </q-card-section>
        <q-card-section>
          <div align="right">
            <q-btn
              label="Cadastrar"
              @click="onSubmit"
              color="negative"
              icon="add"
              to="/cliente/novo/"
              class="q-ml-sm"
            />
            <q-btn
              label="Voltar"
              color="negative"
              icon="arrow_back"
              to="/cliente/"
              class="q-ml-sm"
            />
            <q-btn
              label="Limpar"
              type="reset"
              color="negative"
              icon="clear"
              outline
              class="q-ml-sm"
            />
          </div>
        </q-card-section>

      </q-form>
    </q-card>
  </q-page>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
      cliente: {
        nome: ''
      }
    }
  },
  methods: {
    ...mapActions('cliente', ['cadastrarCliente']),
    onReset () {
      this.cliente.nome = ''
    },
    onSubmit () {
      if (this.isValid()) {
        this.cadastrarCliente(this.cliente)

        this.$q.notify({
          classes: 'text-center',
          color: 'green-5',
          textColor: 'white',
          message: 'Ramal cadastrado com sucesso',
          position: 'top',
          icon: 'checked',
          timeout: 3000
        })
      } else {
        this.$q.notify({
          classes: 'text-center',
          color: 'red-5',
          textColor: 'white',
          message: 'Erro no cadastro',
          position: 'top',
          icon: 'close',
          timeout: 3000
        })
      }
    },
    isValid () {
      let aux = parseInt(this.cliente.nome.trim(' '))
      if (aux === 0) {
        console.log(this.cliente.nome.length)
        return false
      }

      if (!Number.isInteger(aux)) {
        console.log(this.cliente.nome)
        return false
      }

      this.cliente.nome = aux
      return true
    }
  }
}

</script>
