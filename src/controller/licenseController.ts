import {inject, singleton} from 'tsyringe'
import {Request, Response} from 'express'
import {encode} from 'html-entities'
import {promisify} from 'util'
import {readFile} from 'fs'
const readFileAsync = promisify(readFile)

@singleton()
class LicenseController {
	private _licenseText: Promise<string>
	private _licenseHtml: Promise<string>

	constructor(
		@inject('licenseTextFilepath') licenseTextFilepath: string
	) {
		this._licenseText = readFileAsync(licenseTextFilepath, {encoding: 'utf8'})
		this._licenseHtml = new Promise((resolve, reject) => {
			this._licenseText
				.then(text => {
					resolve(`<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>License</title>
	<style>
	pre {
		white-space: pre;
	}
	</style>
</head>
<body>
	<pre>
${encode(text)}
	</pre>
</body>
</html>`)
				})
				.catch(e => reject(e))
		})
	}

	getLicense() {
		return async (req: Request, res: Response): Promise<void> => {
			try {
				if (req.accepts('html')) {
					res.type('html').end(
						await this._licenseHtml
					)
				} else if (req.accepts('json')) {
					res.type('json').end(JSON.stringify({
						license: await this._licenseText
					}))
				} else {
					res.type('text').end(await this._licenseText)
				}
			} catch (e) {
				res.status(500).type('text').end(`KO: ${e}`)
			}
		}
	}
}

export {LicenseController}
