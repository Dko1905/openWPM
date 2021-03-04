import express from 'express'
import {licenseController} from './bootstrap'

// Constants
const PORT = Number.parseInt(process.env.PORT || '8080')
// Express
const app = express()
// Routing
app.use('/license', licenseController.getLicense())
// Listen
app.listen(PORT, () => {
	console.log(`Listening on http://[::1]:${PORT}`)
})
