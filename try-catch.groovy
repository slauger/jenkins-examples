script {
  try {
      sh 'do your stuff'
  } catch (Exception e) {
      sh 'Handle the exception!'
  }
}

