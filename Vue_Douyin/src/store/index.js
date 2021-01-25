import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: { 
      // 存储token
    Authorization: sessionStorage.getItem('Authorization') ? sessionStorage.getItem('Authorization') : '',
    isActive:false  //是否上传成功
  },
  mutations: {
     // 修改token，并将token存入localStorage
    changeLogin (state, user) {
      state.Authorization = user.Authorization;
      sessionStorage.setItem('Authorization', user.Authorization);
    },
    IS_ACTIVE (state, isActive) {
      state.isActive = isActive;
    },
  },
  actions: {
		setIsActive({ commit, state, dispatch }, isActive){
			commit("IS_ACTIVE", isActive);
		}
	},
	getters:{
		isActive: state => {
			let isActive = state.isActive;
			return isActive;
  }
}
})