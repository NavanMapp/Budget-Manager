import api from "./api"

export const getExpenses = async (filters = {}) => {
    const params = new URLSearchParams()
    if (filters.category) 
        params.append('category', filters.category)
    if (filters.startDate) 
        params.append('startDate', filters.startDate)
    if (filters.endDate) 
        params.append('endDate', filters.endDate)
}

export const uploadReceipt = async (expenseId, file) => {
    const formData = new FormData()
    formData.append('file', file)

    const response = await api.post(`/expenses/${expenseId}/receipt`, formData, {
        headers: {
            'content-Type': 'multipart/form-data'
        }
    })
    return response
}