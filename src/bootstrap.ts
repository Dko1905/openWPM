import '@abraham/reflection'
import {container} from 'tsyringe'
import {LicenseController} from './controller/licenseController'

// Setup constants in dep injection
container.register('licenseTextFilepath', {useValue: './LICENSE'})
// Controllers
const licenseController = container.resolve(LicenseController)

export {licenseController}
