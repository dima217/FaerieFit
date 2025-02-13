import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

const MainLayout = () => {
  return (
    <>
      <Stack>
          <Stack.Screen
            name='main'
            options={{
              headerShown: false
            }}
          />
      </Stack>
    </>
  )
}

export default MainLayout

const styles = StyleSheet.create({})